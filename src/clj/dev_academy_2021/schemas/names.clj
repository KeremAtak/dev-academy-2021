(ns dev-academy-2021.schemas.names
  (:require [clojure.spec.alpha :as s]))

(s/def ::amount int?)
(s/def ::name string?)
(s/def ::total-count int?)

(s/def ::person
  (s/keys :req-un [::amount ::name]))

(def names-by-alphabet {:names (s/coll-of ::person)})

(def names-by-popularity {:names (s/coll-of ::person)})

(def total-name-count {:count ::total-count})
