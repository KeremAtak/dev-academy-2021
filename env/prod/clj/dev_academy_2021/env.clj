(ns dev-academy-2021.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[dev-academy-2021 started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[dev-academy-2021 has shut down successfully]=-"))
   :middleware identity})
