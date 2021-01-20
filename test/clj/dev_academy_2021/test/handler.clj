(ns dev-academy-2021.test.handler
  (:require [dev-academy-2021.handler :refer :all]
            [dev-academy-2021.middleware.formats :as formats]
            [clojure.test :refer :all]
            [mount.core :as mount]
            [muuntaja.core :as m]
            [ring.mock.request :refer :all]))

(use-fixtures
  :once
  (fn [f]
    (mount/start #'dev-academy-2021.config/env
                 #'dev-academy-2021.handler/app-routes)
    (f)))

(deftest test-app
  (testing "main route"
    (let [response ((app) (request :get "/swagger-ui/index.html"))]
      (is (= 200 (:status response)))))

  (testing "not-found route"
    (let [response ((app) (request :get "/invalid"))]
      (is (= 404 (:status response)))))
  (testing "services"))
