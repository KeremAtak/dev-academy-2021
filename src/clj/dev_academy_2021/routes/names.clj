(ns dev-academy-2021.routes.names
  (:require [dev-academy-2021.services.names :refer [get-names-by-popularity]]))


(defn name-routes []
   ;; swagger documentation
  ["/names"
   {:swagger {:tags ["names"]}}
   ["/plus"
    {:get {:summary "plus with spec query parameters"
           :responses {200 {:body any?}}
           :handler (fn [_]
                      {:status 200
                       :body {:total (get-names-by-popularity)}})}}]])
