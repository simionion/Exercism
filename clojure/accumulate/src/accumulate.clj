(ns accumulate)

(defn accumulate [fn todo]
  (reduce #(conj %1 (fn %2)) [] todo))

(print (accumulate inc [1 2 3]))
