(ns dev-academy-2021.routes.names
  (:require [dev-academy-2021.schemas.names :as schema]
            [dev-academy-2021.services.names :as service]))


(defn name-routes []
   ;; swagger documentation
  ["/names"
   {:swagger {:tags ["names"]}}
   ["/alphabetical"
    {:get {:summary "get names sorted in alphabetical order"
           :responses {200 {:body schema/names-by-alphabet}}
           :handler (fn [_]
                      {:status 200
                       :body {:names (service/get-names-by-alphabet)}})}}]
   ["/popularity"
    {:get {:summary "get names sorted by popularity"
           :responses {200 {:body schema/names-by-popularity}}
           :handler (fn [_]
                      {:status 200
                       :body {:names (service/get-names-by-popularity)}})}}]
   ["/total-name-count"
    {:get {:summary "get the total count of all names"
           :responses {200 {:body schema/total-name-count}}
           :handler (fn [_]
                      {:status 200
                       :body {:count (service/get-total-name-count)}})}}]])
