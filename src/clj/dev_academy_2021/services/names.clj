(ns dev-academy-2021.services.names
  (:require [clojure.java.io :refer [resource]]
            [muuntaja.core :as m]))

(def get-names-json
  (-> "public/json/names.json"
      (resource)
      (slurp)))

(defn names-json->names-edn [names-json]
  (m/decode "application/json" names-json))

(def names-edn-value
  (let [names-json get-names-json
        names-edn (names-json->names-edn names-json)]
    (:names names-edn)))

(defn get-names-by-alphabet
  "Returns the name list sorted alphabetically."
  []
  (sort-by :name compare names-edn-value))

(defn get-names-by-popularity
  "Returns the name list sorted by popularity."
  []
  (sort-by :amount > names-edn-value))

(defn get-total-name-count
  "Returns the total count of all names."
  []
  (reduce + (map :amount names-edn-value)))
