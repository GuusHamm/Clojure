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

; Project Euler 2

(defn get_fibonacci_number
  [a b total]
  (if (> b 2000000)
    (do (println (str (+ total a b))))
    (do(if (= (mod (+ a b) 2) 0)
         (do ( get_fibonacci_number b (+ a b) (+ total (+ a b))) )
         (do ( get_fibonacci_number b (+ a b) total))))))

(get_fibonacci_number 1 2 2)