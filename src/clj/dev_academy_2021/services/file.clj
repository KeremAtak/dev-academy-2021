(ns dev-academy-2021.services.file
    (:require [clojure.java.io :refer [input-stream resource]]))

(defn get-picture []
  (-> "public/img/warning_clojure.png"
      (resource)
      (input-stream)))
