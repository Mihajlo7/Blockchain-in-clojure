(ns blockchain-clojure.core
  (:import (java.time LocalDateTime)))
;)
; Defined chain  )
(def chain (atom []))

(def new-transactions (atom []))

(defn create-new-block [nonce, previous-hash, hash]
  "Creating new block and adding in chain"
  (let [new-block {:index        (inc (count @chain))
                   :timestamp    (LocalDateTime/now)
                   :nonce        nonce
                   :previousHash previous-hash
                   :hash         hash
                   :transactions @new-transactions
                   }]
    (swap! chain conj new-block)
    (reset! new-transactions [])
    new-block)
  )

(defn get-last-block []
  "Getting the last block from chain"
  (last @chain))
