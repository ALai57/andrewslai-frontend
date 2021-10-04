(ns andrewslai.clj.tools.figwheel-backend
  (:require [andrewslai.clj.http-api.andrewslai :as andrewslai]
            [andrewslai.clj.auth.core :as auth]
            [andrewslai.clj.persistence.postgres2 :as pg]
            [andrewslai.clj.utils.core :as util]
            [taoensso.timbre :as log]))

;; For figwheel testing
(def figwheel-app
  (andrewslai/andrewslai-app {:database (pg/->Database {:dbname   "andrewslai_db"
                                                        :db-port  "5432"
                                                        :host     "localhost"
                                                        :user     "andrewslai"
                                                        :password "andrewslai"
                                                        :dbtype   "postgresql"})
                              :auth     (auth/always-authenticated-backend {:realm_access {:roles ["wedding"]}})
                              :logging  (merge log/*config* {:level :info})}))
