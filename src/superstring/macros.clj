(ns superstring.macros)

;; Taken from [jackknife "0.1.6"]
(defmacro defalias
  "Defines an alias for a var: a new var with the same root binding (if
  any) and similar metadata. The metadata of the alias is its initial
  metadata (as provided by def) merged into the metadata of the original."
  ([name orig]
   `(do
      (alter-meta!
       (if (.hasRoot (var ~orig))
         (def ~name (.getRawRoot (var ~orig)))
         (def ~name))
       ;; When copying metadata, disregard {:macro false}.
       ;; Workaround for http://www.assembla.com/spaces/clojure/tickets/273
       #(conj (dissoc % :macro)
              (apply dissoc (dissoc (meta (var ~orig)) :added)
                     (remove #{:macro} (keys %)))))
      (var ~name)))
  ([name orig doc]
   (list `defalias (with-meta name (assoc (meta name) :doc doc)) orig)))

(defmacro alias-ns
  "Create an alias for all public vars in ns in this ns.

  If the keyword argument :exclude is passed those vars will not be aliased."
  [namespace & {:keys [exclude] :as opts}]
  `(do ~@(map
          (fn [n] `(defalias ~(.sym n) ~(symbol (str (.ns n)) (str (.sym n)))))
          (vals (remove #((set exclude) (first %)) (ns-publics namespace))))))
