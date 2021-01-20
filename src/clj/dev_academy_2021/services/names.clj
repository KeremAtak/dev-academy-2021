(ns dev-academy-2021.services.names
  (:require [clojure.java.io :refer [resource]]
            [muuntaja.core :as m]))

(def get-names-json
  (-> "public/json/names.json"
      (resource)
      (slurp)))

(def names-edn
  (let [names-json get-names-json]
    (m/decode "application/json" names-json)))

(defn get-names-by-popularity
  []
  (let [names (:names names-edn)]
    #_(clojure.pprint/pprint (sort-by :amount > names))
    (sort-by :amount > names)))
