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
           (do (recur (inc number) max (+ sum number) multiples_of_x multiples_of_y))
           (do (recur (inc number) max sum multiples_of_x multiples_of_y)))))))

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
           (do (recur b (+ a b) (+ total (+ a b)) max))
           (do (recur b (+ a b) total max)))))))

(get_fibonacci_number)

; Project Euler 4
(println "Project Euler 4")

(defn is_palindrone?
  [number]
  ; This next bit of cide might seem a bit odd, the reason for this is that reverse
  ; returns a value in the form of ( d d d ) instead of ddd there for the reverse of
  ; the reverse to get the original value in the same format
  (= (reverse (reverse (str number))) (reverse (str number))))

(defn number_of_length
  [length]
  (int (dec (java.lang.Math/pow 10 (int length)))))

(defn palindrone_product
  ([length] (palindrone_product (number_of_length length) (number_of_length length) 0 length ))
  ([a b largest length]
   (if (<= a 0)
     (str largest)
     (if (is_palindrone? (* a b))
       (if (< (int largest) (* a b))
         (if (<= a 98)
           (str largest)
           (recur a (dec b) (* a b) length))
         (recur a (dec b) largest length))
       (if (<= b 0)
         (recur (dec a) (number_of_length length) largest length)
         (recur a (dec b) largest length))))))

(println (palindrone_product 3))

; Project Euler 6
(println "Project Euler 6")

(defn sum_of_square
  ([max] (sum_of_square 1 0 max))
  ([number sum max]
   (let [squared (java.lang.Math/pow number 2)]
     (if (<= max number )
       (int (+ sum squared))
       (recur (inc number) (+ sum squared) max )))))

(defn square_of_sum
  ([max] (square_of_sum 1 0 max))
  ([number sum max]
   (if (<= max number)
     (int (java.lang.Math/pow (+ sum number) 2))
     (recur (inc number) (+ sum number) max))))

(defn difference
  [number_1 number_2]
  (- number_1 number_2))

(println (difference (square_of_sum 100) (sum_of_square 100)))

; Project Euler 14
(println "Project Euler 14")

(defn collatz_sequence
  "Calculates the number of steps it takes for x number too become 1 according to the collatz-sequence "
  ([x] (collatz_sequence x 0))
  ([x steps]
   (if (= 1 x)
     (int (inc steps))
     (if (even? x)
       (recur (/ x 2) (inc steps))
       (recur (+ (* 3 x) 1) (inc steps))))))

; So this solution technically works, but because clojure uses immutatable data this solution takes very long and really isn't effective for a sequence longer then 50.
(defn longest_chain
  ([max] (longest_chain max 1 1))
  ([max length_of_longest_chain number_of_longest_chain]
   (loop [i max]
     (if (<= i 1)
       (int number_of_longest_chain)
       (let [current_chain (collatz_sequence i)]
         (if (> current_chain length_of_longest_chain)
           (longest_chain (dec i) current_chain i))
         (recur (dec i)))))))

(println (time (longest_chain 20)))

