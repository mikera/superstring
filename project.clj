(defproject superstring "1.1.0-SNAPSHOT"
  :description "String manipulation library for clojure"
  :url "http://github.com/expez/superstring"
  :license {:name "Eclipse Public License 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :year 2015
            :key "epl-1.0"}
  :plugins [[codox "0.8.11"]]
  :codox {:src-dir-uri "http://github.com/expez/superstring/blob/master/"
          :src-linenum-anchor-prefix "L"}
  :profiles {:dev {:dependencies [[org.clojure/test.check "0.7.0"]
                                  [com.cemerick/piggieback "0.2.1"]]
                   :repl-options {:init-ns superstring.core
                                  :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}
             :provided {:dependencies [[org.clojure/clojure "1.7.0"]
                                       [org.clojure/clojurescript "1.7.28"]]}})
