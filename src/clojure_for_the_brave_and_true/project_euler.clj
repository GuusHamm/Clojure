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

(defn get_multiples_of_x_y
  [number max sum multiples_of_x multiples_of_y]
  (if (> number (dec max))
    (do (println sum))
    (do (if (or (= (mod number multiples_of_x) 0) (= (mod number multiples_of_y) 0))
          (do (get_multiples_of_x_y (inc number) max (+ sum number) multiples_of_x multiples_of_y))
          (do (get_multiples_of_x_y (inc number) max sum multiples_of_x multiples_of_y))))))

(get_multiples_of_x_y 1 1000 0 3 5)

; Project Euler 2

(defn get_fibonacci_number
  [a b total]
  (if (> b 2000000)
    (do (println (str (+ total a b))))
    (do (if (= (mod (+ a b) 2) 0)
          (do (get_fibonacci_number b (+ a b) (+ total (+ a b))))
          (do (get_fibonacci_number b (+ a b) total))))))

(get_fibonacci_number 1 2 2)

