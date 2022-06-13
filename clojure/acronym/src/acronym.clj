(ns acronym)

(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (->>
    (re-seq #"\b\w|(?<=[a-z])[A-Z]" phrase)
    (reduce str)
    clojure.string/upper-case
    ))
