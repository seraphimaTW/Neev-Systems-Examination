#!/usr/bin/env bash
set -e -x
script_dir="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
# shellcheck source=scripts/style.sh
source "$script_dir/style.sh"

info_msg "RUNNING BUILD"
./gradlew clean build --no-daemon $@
success_msg "COMPLETED BUILD"