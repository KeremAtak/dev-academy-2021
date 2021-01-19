(ns dev-academy-2021.routes.health
    (:require [ring.util.http-response :refer :all]))

(defn health-routes []
  ["/ping"
   ; note the missing swagger tag, it will be tagged as default
   {:get (constantly (ok {:message "pong"}))}])
