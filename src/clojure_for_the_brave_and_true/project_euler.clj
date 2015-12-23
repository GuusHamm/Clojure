(ns clojure-for-the-brave-and-true.project_euler)

; Exercise 2
(defn number_adder
  [number]
  (+ number 100))

; Exercise 3
(defn dec_maker
  [dec-by]
  #(- % dec-by))

(def dec9 (dec_maker 9))

(dec9 21)

;Project Euler 1
(println "Project Euler 1")

(defn get_multiples_of_x_y
  ([max multiples_of_x multiples_of_y] (get_multiples_of_x_y 1 max 0 multiples_of_x multiples_of_y))
  ([number max sum multiples_of_x multiples_of_y]
   (if (> number (dec max))
     (do (println sum))
     (do (if (or (= (mod number multiples_of_x) 0) (= (mod number multiples_of_y) 0))
           (do (get_multiples_of_x_y (inc number) max (+ sum number) multiples_of_x multiples_of_y))
           (do (get_multiples_of_x_y (inc number) max sum multiples_of_x multiples_of_y)))))))

(defn get_multiples_of_3_5
  [max]
  (get_multiples_of_x_y max 3 5 ))

(get_multiples_of_3_5 1000)

; Project Euler 2
(println "Project Euler 2")

(defn get_fibonacci_number
  ([] (get_fibonacci_number 1 2 2 2000000))
  ([max] (get_fibonacci_number 1 2 2 max))
  ([a b total max]
   (if (> b max)
     (do (println (str (+ total a b))))
     (do (if (= (mod (+ a b) 2) 0)
           (do (get_fibonacci_number b (+ a b) (+ total (+ a b)) max))
           (do (get_fibonacci_number b (+ a b) total max)))))))

(get_fibonacci_number)

