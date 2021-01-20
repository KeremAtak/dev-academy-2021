(ns dev-academy-2021.services.names
  (:require [clojure.java.io :refer [resource]]
            [muuntaja.core :as m]))

(def get-names-json
  (-> "public/json/names.json"
      (resource)
      (slurp)))

(def names-json->names-edn
  (m/decode "application/json" get-names-json))

(def names-edn-value
  (:names names-json->names-edn))

(defn- name-matches?
  "Returns the name-value pair if the name matches."
  [{:keys [name name-edn-value]}]
  (when (= (get name-edn-value :name) name)
    name-edn-value))

(defn- name->matching-name
  "Returns the existing name if it exists"
  [name]
  (some #(name-matches? {:name name
                         :name-edn-value %}) names-edn-value))

(defn get-names-by-alphabet
  "Returns the name list sorted alphabetically."
  []
  (sort-by :name compare names-edn-value))

(defn get-count-by-name
  "Returns the count of a single name."
  []
  (if-let [matching-name (name->matching-name "Ville")]
    (:amount matching-name)
    0))

(defn get-names-by-popularity
  "Returns the name list sorted by popularity."
  []
  (sort-by :amount > names-edn-value))

(defn get-total-name-count
  "Returns the total count of all names."
  []
  (reduce + (map :amount names-edn-value)))
