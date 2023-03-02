(ns bob)

(def reg-rsp
  {

   }
  )

(defn response-for [s]
  (condp (comp s re-find not-empty) s
    #"^[^a-z]*[A-Z]+[^a-z]*\?$" "Calm down, I know what I'm doing!"
    #"^[^a-z]*[A-Z]+[^a-z]*$" "Whoa, chill out!"
    #"\?\s*$" "Sure."
    #"\w+" "Whatever."
    ))
