(ns dev-academy-2021.test.routes.names
  (:require [clojure.test :refer :all]
            [dev-academy-2021.handler :refer [app]]
            [dev-academy-2021.test.routes.names-helper :as helper]
            [muuntaja.core :as m]
            [ring.mock.request :refer [query-string request]]))

(deftest test-name-routes
  (testing "/api/names/alphabetical"
    (let [response ((app) (-> (request :get "/api/names/alphabetical")))]
      (is (= 200 (:status response)))
      (is (= helper/names-sorted-by-alphabet (m/decode-response-body response)))))

  (testing "/api/names/count-by-name"
    (let [count-by-name "/api/names/count-by-name"]

      (testing "Ville"
        (let [response ((app) (-> (request :get count-by-name)
                                  (query-string {:name "Ville"})))]
          (is (= 200 (:status response)))
          (is (= {:count 24} (m/decode-response-body response)))))

      (testing "Tero"
        (let [response ((app) (-> (request :get count-by-name)
                                  (query-string {:name "Tero"})))]
          (is (= 200 (:status response)))
          (is (= {:count 15} (m/decode-response-body response)))))

      (testing "Mozart"
        (let [response ((app) (-> (request :get count-by-name)
                                  (query-string {:name "Mozart"})))]
          (is (= 200 (:status response)))
          (is (= {:count 0} (m/decode-response-body response)))))

      (testing "Empty string"
        (let [response ((app) (-> (request :get count-by-name)
                                  (query-string {:name ""})))]
          (is (= 200 (:status response)))
          (is (= {:count 0} (m/decode-response-body response)))))))

  (testing "/api/names/popularity"
    (let [response ((app) (-> (request :get "/api/names/popularity")))]
      (is (= 200 (:status response)))
      (is (= helper/names-sorted-by-popularity (m/decode-response-body response)))))

  (testing "/api/names/total-count"
    (let [response ((app) (-> (request :get "/api/names/total-count")))]
      (is (= 200 (:status response)))
      (is (= {:count 211} (m/decode-response-body response))))))
