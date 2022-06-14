(ns all-your-base)

(defn convert [from-base list-int to-base]
  (cond (< from-base 2) nil
        (< to-base 2) nil
        (some neg-int? list-int) nil
        (and (< from-base 10) (some #(>= %1 from-base) list-int)) nil
        (empty? list-int) '()
        (every? zero? list-int) '(0)
        :OK (->> list-int
                 (reduce #(+ (* from-base %1) %2))
                 (iterate #(quot % to-base))
                 (take-while pos?)
                 (map #(rem % to-base))
                 reverse)))
