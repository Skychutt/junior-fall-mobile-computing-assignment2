"""Refresh the submission archive and debug APK after a successful build."""
from pathlib import Path
import shutil
import zipfile

project = Path(__file__).resolve().parents[1]
output = project / "deliverables"
apk = project / "app/build/outputs/apk/debug/app-debug.apk"
if not apk.is_file():
    raise SystemExit("Build first: ./gradlew :app:assembleDebug")
output.mkdir(exist_ok=True)
shutil.copy2(apk, output / "fruit-garden-debug.apk")
excluded = {".git", ".gradle", ".idea", ".kotlin", "build", "deliverables", "archive", ".cxx", "__pycache__"}
with zipfile.ZipFile(output / "assignment2-source.zip", "w", zipfile.ZIP_DEFLATED) as archive:
    for file in sorted(project.rglob("*")):
        relative = file.relative_to(project)
        if any(part in excluded for part in relative.parts):
            continue
        if file.name in {"local.properties", ".DS_Store", ".env"} or file.name.startswith(".env."):
            continue
        if file.is_file() and file.suffix not in {".jks", ".keystore"}:
            archive.write(file, Path(project.name) / relative)
print("Updated deliverables/assignment2-source.zip and fruit-garden-debug.apk")
