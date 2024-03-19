(function(api) {

    api.sectionConstructor['luxury-watches-upsell'] = api.Section.extend({
        attachEvents: function() {},
        isContextuallyActive: function() {
            return true;
        }
    });

    const luxury_watches_section_lists = ['banner', 'service'];
    luxury_watches_section_lists.forEach(luxury_watches_homepage_scroll);

    function luxury_watches_homepage_scroll(item, index) {
        item = item.replace(/-/g, '_');
        wp.customize.section('luxury_watches_' + item + '_section', function(section) {
            section.expanded.bind(function(isExpanding) {
                wp.customize.previewer.send(item, { expanded: isExpanding });
            });
        });
    }
})(wp.customize);