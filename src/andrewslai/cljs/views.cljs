(ns andrewslai.cljs.views
  (:require [andrewslai.cljs.article :as article]
            [andrewslai.cljs.article-cards :as cards]
            [andrewslai.cljs.navbar :as nav]
            [andrewslai.cljs.pages.editor :refer [editor-ui]]
            [andrewslai.cljs.pages.admin :refer [login-ui]]
            [clojure.string :refer [includes?]]
            [re-frame.core :refer [subscribe
                                   dispatch]]
            [taoensso.timbre :refer-macros [infof]]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Landing pages
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn home []
  [:div
   [nav/primary-nav]
   [cards/recent-content-display]])

(defn thoughts []
  [:div
   [nav/primary-nav]
   [:p "Thoughts"]
   [:div#primary-content
    [article/primary-content]]
   [:div#rcb
    [cards/recent-content-display "thoughts"]]])

(defn archive []
  [:div
   [nav/primary-nav]
   [:p "Archive"]
   [:div#primary-content
    [article/primary-content]]
   [:div#rcb
    ]])

(defn reset-portfolio-cards [x]
  (let [clicked-element (.-target x)
        clicked-class (.-className clicked-element)]
    (when-not (or (includes? clicked-class "resume-info-image")
                  (includes? clicked-class "resume-info-icon")
                  (includes? clicked-class "card-description")
                  (includes? clicked-class "card-title")
                  (includes? clicked-class "card-text"))
      (dispatch [:reset-portfolio-cards]))))

(defn about []
  [:div {:onClick reset-portfolio-cards
         :style {:height "100%"
                 :width "100%"
                 :position "absolute"}}
   [nav/primary-nav]
   [:div {:style {:height "100%"}}]])

(defn research []
  [:div
   [nav/primary-nav]
   [:p "Research"]
   [:div#primary-content
    [article/primary-content]]
   [:div#rcb
    [cards/recent-content-display "research"]]])

(defn full-page
  [article recent-content]
  [:div
   [nav/primary-nav]
   [:div#primary-content [article/article article]]
   [:div#rcb [cards/recent-content-cards recent-content]]])

(defn data-analysis []
  [:div
   [nav/primary-nav]
   [:p "Data Analysis"]
   [:div#primary-content
    [article/primary-content]]
   [:div#rcb
    [cards/recent-content-display "data-analysis"]]])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Test pages
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(def panels {:home [home]
             :thoughts [thoughts]
             :archive [archive]
             :about [about]
             :research [research]
             :data-analysis [data-analysis]
             :admin [login-ui]
             :editor [editor-ui]
             })

(defn app []
  (let [active-panel (subscribe [:active-panel])]
    (infof "Active panel %s" @active-panel)
    (get panels @active-panel)))
