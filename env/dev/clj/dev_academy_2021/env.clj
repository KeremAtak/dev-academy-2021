(ns dev-academy-2021.env
  (:require [dev-academy-2021.dev-middleware :refer [wrap-dev]]
            [clojure.tools.logging :as log]
            [selmer.parser :as parser]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[dev-academy-2021 started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[dev-academy-2021 has shut down successfully]=-"))
   :middleware wrap-dev})
