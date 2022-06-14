(ns bob)

(def reg-rsp
  {
   #"^[^a-z]*[A-Z]+[^a-z]*\?$" "Calm down, I know what I'm doing!"
   #"^[^a-z]*[A-Z]+[^a-z]*$"   "Whoa, chill out!"
   #"\?\s*$"                   "Sure."
   #"\w+"                      "Whatever."
   }
  )

(defn response-for [s]
  (-> (fn [rez [reg rsp]]
        (or rez (when (not-empty (re-find reg s)) rsp)))
      (reduce nil reg-rsp)
      (or "Fine. Be that way!")))
