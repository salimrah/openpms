//== Class definition

var DatatableRecordSelectionDemo = function() {
	//== Private functions
	var options = {
		// datasource definition
		data: {
			type: 'remote',
			source: {
				read: {
					method:'GET',
					url: 'http://localhost:8080/projects/',
				},
			},
			pageSize: 10,
			serverPaging: true,
			serverFiltering: true,
			serverSorting: true,
		},

		// layout definition
		layout: {
			theme: 'default', // datatable theme
			class: '', // custom wrapper class
			scroll: true, // enable/disable datatable scroll both horizontal and vertical when needed.
			height: 550, // datatable's body's fixed height
			footer: false // display/hide footer
		},

		// column sorting
		sortable: true,

		pagination: true,

		// columns definition
		columns: [
			{
				field: 'id',
				title: 'ID',
			}, {
				field: 'shortName',
				title: 'Short Name',
			}, {
				field: 'description',
				title: 'Description',
			}, {
				field: 'expectedStartDate',
				title: 'ex StartDate',
			}, {
				field: 'expectedEndDate',
				title: 'ex EndDate',
			}, {
				field: 'actualStartDate',
				title: 'ac StartDate',
			}],
	};

	// basic demo
	var localSelectorDemo = function() {

		options.search = {
			input: $('#generalSearch'),
		};

		var datatable = $('#local_record_selection').mDatatable(options);

		$('#m_form_status').on('change', function() {
			datatable.search($(this).val().toLowerCase(), 'Status');
		});

		$('#m_form_type').on('change', function() {
			datatable.search($(this).val().toLowerCase(), 'Type');
		});

		$('#m_form_status,#m_form_type').selectpicker();

		datatable.on('m-datatable--on-check m-datatable--on-uncheck m-datatable--on-layout-updated', function(e) {
			var checkedNodes = datatable.rows('.m-datatable__row--active').nodes();
			var count = checkedNodes.length;
			$('#m_datatable_selected_number').html(count);
			if (count > 0) {
				$('#m_datatable_group_action_form').collapse('show');
			} else {
				$('#m_datatable_group_action_form').collapse('hide');
			}
		});

		$('#m_modal_fetch_id').on('show.bs.modal', function(e) {
			var ids = datatable.rows('.m-datatable__row--active').
				nodes().
				find('.m-checkbox--single > [type="checkbox"]').
				map(function(i, chk) {
					return $(chk).val();
				});
			var c = document.createDocumentFragment();
			for (var i = 0; i < ids.length; i++) {
				var li = document.createElement('li');
				li.setAttribute('data-id', ids[i]);
				li.innerHTML = 'Selected record ID: ' + ids[i];
				c.appendChild(li);
			}
			$(e.target).find('.m_datatable_selected_ids').append(c);
		}).on('hide.bs.modal', function(e) {
			$(e.target).find('.m_datatable_selected_ids').empty();
		});

	};

	var serverSelectorDemo = function() {

		// enable extension
		options.extensions = {
			checkbox: {},
		};
		options.search = {
			input: $('#generalSearch1'),
		};

		var datatable = $('#server_record_selection').mDatatable(options);

		$('#m_form_status1').on('change', function() {
			datatable.search($(this).val().toLowerCase(), 'Status');
		});

		$('#m_form_type1').on('change', function() {
			datatable.search($(this).val().toLowerCase(), 'Type');
		});

		$('#m_form_status1,#m_form_type1').selectpicker();

		datatable.on('m-datatable--on-click-checkbox m-datatable--on-layout-updated', function(e) {
			// datatable.checkbox() access to extension methods
			var ids = datatable.checkbox().getSelectedId();
			var count = ids.length;
			$('#m_datatable_selected_number1').html(count);
			if (count > 0) {
				$('#m_datatable_group_action_form1').collapse('show');
			} else {
				$('#m_datatable_group_action_form1').collapse('hide');
			}
		});

		$('#m_modal_fetch_id_server').on('show.bs.modal', function(e) {
			var ids = datatable.checkbox().getSelectedId();
			var c = document.createDocumentFragment();
			for (var i = 0; i < ids.length; i++) {
				var li = document.createElement('li');
				li.setAttribute('data-id', ids[i]);
				li.innerHTML = 'Selected record ID: ' + ids[i];
				c.appendChild(li);
			}
			$(e.target).find('.m_datatable_selected_ids').append(c);
		}).on('hide.bs.modal', function(e) {
			$(e.target).find('.m_datatable_selected_ids').empty();
		});

	};

	return {
		// public functions
		init: function() {
			//localSelectorDemo();
			serverSelectorDemo();
		},
	};
}();

jQuery(document).ready(function() {
	DatatableRecordSelectionDemo.init();
});