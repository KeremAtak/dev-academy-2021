(ns dev-academy-2021.schemas.names
  (:require [clojure.spec.alpha :as s]))

(s/def ::amount int?)
(s/def ::name string?)
(s/def ::single-name-count int?)
(s/def ::total-name-count int?)

(s/def ::name-count
  (s/keys :req-un [::amount ::name]))

(def names-by-alphabet {:names (s/coll-of ::name-count)})

(def names-by-popularity {:names (s/coll-of ::name-count)})

(def single-name-count {:count ::single-name-count})

(def total-name-count {:count ::total-name-count})
