(ns user
  "Userspace functions you can run by default in your local REPL."
  (:require [dev-academy-2021.config :refer [env]]
            [dev-academy-2021.core :refer [start-app]]
            [dev-academy-2021.db.core]
            [clojure.pprint]
            [clojure.spec.alpha :as s]
            [conman.core :as conman]
            [expound.alpha :as expound]
            [luminus-migrations.core :as migrations]
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

(defn restart-db
  "Restarts dev-academy-2021."
  []
  (mount/stop #'dev-academy-2021.db.core/*db*)
  (mount/start #'dev-academy-2021.db.core/*db*)
  (binding [*ns* 'dev-academy-2021.db.core]
    (conman/bind-connection dev-academy-2021.db.core/*db* "sql/math-queries.sql")))

(defn reset-db
  "Resets database."
  []
  (migrations/migrate ["reset"] (select-keys env [:database-url])))

(defn migrate
  "Migrates database up for all outstanding migrations."
  []
  (migrations/migrate ["migrate"] (select-keys env [:database-url])))

(defn rollback
  "Rollback latest database migration."
  []
  (migrations/migrate ["rollback"] (select-keys env [:database-url])))

(defn create-migration
  "Create a new up and down migration file with a generated timestamp and `name`."
  [name]
  (migrations/create name (select-keys env [:database-url])))
