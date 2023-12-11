(ns blockchain-clojure.hash-test
  (:require [blockchain-clojure.hash :refer :all]
            [midje.sweet :refer :all]))

(fact "Hash function"
      (sha "midje" "SHA-256") => "1bd4d4e1f843b2359a8a30f7b8361ad2cc2b7ecd5b2959058098abe8b740622e"
      (sha "Mihajlo")=> "b45e38c552442bd4d21f57a30700e13fda94b74a49cd7e381086e583ae56ccfb" )
