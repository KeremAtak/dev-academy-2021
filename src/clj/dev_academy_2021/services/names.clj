(ns dev-academy-2021.services.names
  (:require [clojure.java.io :refer [resource]]
            [muuntaja.core :refer [decode]]))

(defn- get-names-json []
  (-> "public/json/names.json"
      (resource)
      (slurp)))

(defn- names-json->names-edn []
  (let [names-json (get-names-json)]
    (decode "application/json" names-json)))

(defn get-names-by-popularity []
  (names-json->names-edn))
