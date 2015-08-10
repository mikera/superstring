# Changelog

## master (unreleased)

### New features

* clojurescript support
* `char-at` returning the character at some index.
* `re-quote` which returns a string matching the input string exactly,
  for use in regular expressions.

### Bugs fixed

* `mixed-case?` is now false on strings like "123" where no character has a case.
* `swap-case` on "ß" now returns "SS"
* Fix `starts-with?` throwing exception when `prefix` is longer than `s`.
