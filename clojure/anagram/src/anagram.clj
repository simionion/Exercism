(ns anagram)

(defn anagrams-for [word prospect-list] ;; <- arglist goes here
  (->> (clojure.string/join " " prospect-list)
    (re-matches (
              re-pattern 
              (format "[%s]{%d}" word)
              (count word)))
    )
)
