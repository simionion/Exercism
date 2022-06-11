(ns interest-is-interesting)

(defn interest-rate
  "TODO: add docstring"
  [balance]
  (cond
    (< balance 0) -3.213
    (< balance 1000) 0.5
    (< balance 5000) 1.621
    :default 2.475
    ))

(defn annual-balance-update [balance]
  ;(-> balance interest-rate (* (max balance (- balance))) bigdec (+ balance)))
  (+ balance
     (* 0.01M (* (bigdec (.abs balance)) (bigdec (interest-rate balance))))))


(defn amount-to-donate
  "TODO: add docstring"
  [balance tax-free-percentage]
  (int
    (let [regular-donation (* (/ balance 100) tax-free-percentage)
          double-donation (* regular-donation 2)]
      (if (< (annual-balance-update balance) 0)
        0
        (if (> balance 0) double-donation regular-donation)))
      ))
