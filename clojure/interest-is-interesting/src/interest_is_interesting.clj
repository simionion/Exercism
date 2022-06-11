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
  (-> balance
      interest-rate
      bigdec
      (* (.abs balance) 0.01M)
      (+ balance)))


(defn amount-to-donate
  "TODO: add docstring"
  [balance tax-free-percentage]
  (if (< balance 0)
    0
    (-> balance
        (/ 100)
        (* tax-free-percentage 2)
        int)))
