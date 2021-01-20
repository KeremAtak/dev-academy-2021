(ns dev-academy-2021.routes.names
  (:require [dev-academy-2021.schemas.names :refer [names-by-popularity]]
            [dev-academy-2021.services.names :refer [get-names-by-popularity]]))


(defn name-routes []
   ;; swagger documentation
  ["/names"
   {:swagger {:tags ["names"]}}
   ["/popularity"
    {:get {:summary "plus with spec query parameters"
           :responses {200 {:body names-by-popularity}}
           :handler (fn [_]
                      {:status 200
                       :body {:names (get-names-by-popularity)}})}}]])
