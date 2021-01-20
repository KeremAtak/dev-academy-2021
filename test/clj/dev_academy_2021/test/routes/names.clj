(ns dev-academy-2021.test.routes.names
  (:require [clojure.test :refer :all]
            [dev-academy-2021.handler :refer [app]]
            [dev-academy-2021.test.routes.names-helper :as helper]
            [muuntaja.core :as m]
            [ring.mock.request :refer [request]]))

(deftest test-name-routes
  (testing "/api/names/alphabetical"
    (let [response ((app) (-> (request :get "/api/names/alphabetical")))]
      (is (= 200 (:status response)))
      (is (= helper/names-sorted-by-alphabet (m/decode-response-body response)))))
  (testing "/api/names/popularity"
    (let [response ((app) (-> (request :get "/api/names/popularity")))]
      (is (= 200 (:status response)))
      (is (= helper/names-sorted-by-popularity (m/decode-response-body response)))))
  (testing "/api/names/total-count"
    (let [response ((app) (-> (request :get "/api/names/total-count")))]
      (is (= 200 (:status response)))
      (is (= helper/names-total-count (m/decode-response-body response))))))
