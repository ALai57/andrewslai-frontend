(ns andrewslai.cljs.workspaces.main
  (:require [nubank.workspaces.core :as ws]
            [andrewslai.cljs.workspaces.cards.login]))


(defn on-js-load [] (ws/after-load))

(defonce init (ws/mount))
