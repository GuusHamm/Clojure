(ns clojure-for-the-brave-and-true.vampmatic-3000)

(def vampire-database
  {0 {:makes-blood-puns? false, :has-pulse? true  :name "McFishwich"}
   1 {:makes-blood-puns? false, :has-pulse? true  :name "McMackson"}
   2 {:makes-blood-puns? true,  :has-pulse? false :name "Damon Salvatore"}
   3 {:makes-blood-puns? true,  :has-pulse? true  :name "Mickey Mouse"}})

(defn vampire-related-details
      [social-security-number]
      (Thread/sleep 1000)
      (get vampire-database social-security-number))

(defn vampire?
      [record]
      (and (:makes-blood-puns? record)
           (not (:has-pulse? record))
           record))

(def not-vampire? (complement vampire?))

(defn identify-vampire
      [social-security-numbers]
      (first (filter vampire?
                     (map vampire-related-details social-security-numbers))))

(defn identify-humans
  [social-security-numbers]
  (filter not-vampire?
          (map vampire-related-details social-security-numbers)))

(time (vampire-related-details 0))
(time (def mapped-details (map vampire-related-details (range 0 1000000))))
(time (first mapped-details))
(time (identify-vampire (range 0 1000000)))
(time (identify-humans (range 0 1000000)))