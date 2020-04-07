#!/usr/bin/env bash
display_header() {
  set +x
  printf '\n \033[34m ===== %s ===== \033[0m\n\n' "$1"
  set -x
}

success_msg() {
  set +x
  printf '\n \033[32m SUCCESS: %s \033[0m\n\n' "$*"
  set -x
}

fail_msg() {
  set +x
  printf '\n \033[31m FAIL: %s \033[0m\n\n' "$*"
  set -x
}

info_msg() {
  set +x
  printf '\n \033[33m %s \033[0m\n\n' "$*"
  set -x
}
