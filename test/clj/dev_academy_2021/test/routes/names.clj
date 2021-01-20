(ns dev-academy-2021.test.routes.names
  (:require [clojure.test :refer :all]
            [dev-academy-2021.handler :refer [app]]
            [dev-academy-2021.test.routes.names-helper :refer [names-sorted-by-popularity]]
            [muuntaja.core :as m]
            [ring.mock.request :refer [request]]))

(deftest test-name-routes
  (testing "get-names-by-popularity"
    (let [response ((app) (-> (request :get "/api/names/popularity")))]
      (is (= 200 (:status response)))
      (is (= names-sorted-by-popularity (m/decode-response-body response))))))
