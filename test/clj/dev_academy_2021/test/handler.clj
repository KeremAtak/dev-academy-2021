(ns dev-academy-2021.test.handler
  (:require [clojure.test :refer :all]
            [dev-academy-2021.handler :refer [app]]
            [mount.core :as mount]
            [ring.mock.request :refer [request]]))

(use-fixtures
  :once
  (fn [f]
    (mount/start #'dev-academy-2021.handler/app-routes)
    (f)))

(deftest test-app
  (testing "main route"
    (let [response ((app) (request :get "/swagger-ui/index.html"))]
      (is (= 200 (:status response)))))

  (testing "not-found route"
    (let [response ((app) (request :get "/invalid"))]
      (is (= 404 (:status response))))))
