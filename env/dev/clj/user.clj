(ns user
  "Userspace functions you can run by default in your local REPL."
  (:require [dev-academy-2021.core :refer [start-app]]
            [clojure.pprint]
            [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [mount.core :as mount]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(add-tap (bound-fn* clojure.pprint/pprint))

(defn start
  "Starts application.
  You'll usually want to run this on startup."
  []
  (mount/start-without #'dev-academy-2021.core/repl-server))

(defn stop
  "Stops application."
  []
  (mount/stop-except #'dev-academy-2021.core/repl-server))

(defn restart
  "Restarts application."
  []
  (stop)
  (start))
