(ns anagram
  (:require [clojure.string :refer [lower-case] :rename {lower-case lc}]))

(defn anagrams-for [word prospect-list]
  (let [hasher #(reduce + (map int (lc %1)))]
    (->> (remove #(= (lc %1) (lc word)) prospect-list)
         (filter #(= (hasher %1) (hasher word)))
         )))
