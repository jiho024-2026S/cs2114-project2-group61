import json
import os
import re

import spotipy
from spotipy.oauth2 import SpotifyOAuth

PLAYLIST_URL = "https://open.spotify.com/playlist/3YwvRGtw88R06FzwqDYIrv"
OUTPUT_FILE = "songs.txt"

# Add this exact redirect URI to your Spotify Developer Dashboard app settings.
REDIRECT_URI = "http://127.0.0.1:8888/callback"
SCOPE = "playlist-read-private playlist-read-collaborative"


def java_string(value: str) -> str:
    """Escape a Python string for a Java string literal."""
    return json.dumps(value, ensure_ascii=False)


def first_genre(sp, artist_id: str) -> str:
    genres = sp.artist(artist_id).get("genres", [])
    return genres[0].title() if genres else "Unknown"


def release_year(release_date: str) -> int:
    match = re.search(r"\d{4}", release_date or "")
    return int(match.group()) if match else 0


def main() -> None:
    client_id = os.environ.get("SPOTIPY_CLIENT_ID")
    if not client_id:
        raise RuntimeError("Set SPOTIPY_CLIENT_ID before running this script.")

    sp = spotipy.Spotify(
        auth_manager=SpotifyOAuth(
            client_id=client_id,
            redirect_uri=REDIRECT_URI,
            scope=SCOPE,
            open_browser=True,
        )
    )

    lines = []
    results = sp.playlist_items(
        PLAYLIST_URL,
        additional_types=("track",),
        limit=100,
        market="US",
    )

    while results:
        for item in results["items"]:
            track = item.get("item") or item.get("track")
            if not track or track.get("type") != "track" or track.get("is_local"):
                continue

            title = track["name"]
            artist = track["artists"][0]
            artist_name = artist["name"]
            genre = first_genre(sp, artist["id"])
            year = release_year(track["album"].get("release_date", ""))

            lines.append(
                f"songs.addToEnd(new Song({java_string(title)}, "
                f"{java_string(artist_name)}, {java_string(genre)}, {year}));"
            )

        if not results.get("next"):
            break
        results = sp.next(results)

    with open(OUTPUT_FILE, "w", encoding="utf-8") as output:
        output.write("\n".join(lines) + ("\n" if lines else ""))

    print(f"Wrote {len(lines)} songs to {OUTPUT_FILE}")


if __name__ == "__main__":
    main()