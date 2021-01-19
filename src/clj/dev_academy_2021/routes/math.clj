(ns dev-academy-2021.routes.math
  (:require [dev-academy-2021.services.math :refer [sum]]
            [dev-academy-2021.schemas.math :refer [plus-request plus-response]]))


(defn math-routes []
   ;; swagger documentation
  ["/math"
   {:swagger {:tags ["math"]}}
   ["/plus"
    {:get {:summary "plus with spec query parameters"
           :parameters {:query plus-request}
           :responses {200 {:body plus-response}}
           :handler (fn [{{:keys [query]} :parameters}]
                      {:status 200
                       :body {:total (sum query)}})}
     :post {:summary "plus with spec body parameters"
            :parameters {:body plus-request}
            :responses {200 {:body plus-response}}
            :handler (fn [{{:keys [body]} :parameters}]
                       {:status 200
                        :body {:total (sum body)}})}}]])

