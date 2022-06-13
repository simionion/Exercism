(ns accumulate)

(defn accumulate [fn todo]
  (let [rez (atom [])]
    (doseq [task todo]
      (swap! rez conj (fn task)))
    @rez
    ))
