(ns anagram
  (:require [clojure.string :refer [lower-case] :rename {lower-case lc}]))

(defn anagrams-for [word prospect-list]
  (->> prospect-list
       (remove #(= (lc %1) (lc word)))
       (filter #(= (-> %1 lc sort) (-> word lc sort)))))
