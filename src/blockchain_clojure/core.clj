(ns blockchain-clojure.core
  (:import (java.time LocalDateTime)))
;)
; Defined chain  )
(def chain (atom []))

(def pending-transactions (atom []))

(defn create-new-block [nonce, previous-hash, hash]
  "Creating new block and adding in chain"
  (let [new-block {:index        (inc (count @chain))
                   :timestamp    (LocalDateTime/now)
                   :nonce        nonce
                   :previousHash previous-hash
                   :hash         hash
                   :transactions @pending-transactions
                   }]
    (swap! chain conj new-block)
    (reset! pending-transactions [])
    new-block)
  )

(defn get-last-block []
  "Getting the last block from chain"
  (last @chain))

(defn get-index-for-transaction []

  (if (empty? @chain)
    1
    (-> (get-last-block)
        (get :index)
        inc)))

(defn create-new-transaction [amount sender receiver]
  "Creating new transaction"
  (let [new-transaction {:amount amount
                         :sender sender
                         :receiver receiver}]
    (swap! pending-transactions conj new-transaction))
(get-index-for-transaction))

;(defn sha-256 [input])

(defn hash-block [block]
  "Function return hash data for block"
  (let [block-data (str (get-in block [:index :timestamp :nonce :previousHash]))]))