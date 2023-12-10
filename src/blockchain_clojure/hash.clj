(ns blockchain-clojure.hash
  (:import [java.security MessageDigest]))


(defn sha
  "Implementing algorithm for hashing"
  ([input] (sha input "SHA-256"))
  ([input alg]
   (let [digest (MessageDigest/getInstance alg)
         bytes  (.digest digest (.getBytes input "UTF-8"))
         hex-str (apply str (map #(format "%02x" %) bytes))]
     hex-str)))

(def sha-256
  (fn [input]
    (sha input )))
